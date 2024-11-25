<template>
  <barra-navegacao></barra-navegacao>

  <div class="lista">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
          <h1>Lista de Alunos</h1>
          <table class="table table-primary table-striped ">
            <thead class="table-dark">
              <tr>
                <th>Nome</th>
                <th>Matricula</th>
                <th>Telefone</th>
                <th>Email</th>
                <th>Curso</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="aluno in alunos" :key="aluno.id">
                <td>{{ aluno.nome }}</td>
                <td>{{ aluno.matricula }}</td>
                <td>{{ aluno.telefone }}</td>
                <td>{{ aluno.email }}</td>
                <td>{{ aluno.curso }}</td>
                <td align="center">
                  <button class="btn btn-primary btn-sm" @click="editarAluno(aluno.id)">Editar</button>
                  <button class="btn btn-danger btn-sm" @click="excluirAluno(aluno.id)">Excluir</button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import BarraNavegacao from "@/components/BarraNavegacao.vue";
import axios from "axios";

export default {
  components: { BarraNavegacao },
  data() {
    return {
      alunos: [],
      aluno: {
        nome: "",
        matricula: "",
        telefone: "",
        email: "",
        curso: "",
      }

    };
  },
  mounted() {
    
    this.getAlunos();
  },
  methods: {
    async getAlunos() {
      try {
        const response = await axios.get("http://localhost:8080/alunos");
        this.alunos = response.data;
      } catch (ex) {
        console.log("Erro ao buscar alunos:", ex);
      }
    },


       async salvar() {
      try {
        const response = await axios.post("http://localhost:8080/alunos",
          this.aluno, {
          headers: {
            "Content-Type": "application/json",
          },
        });
        if (response.status === 200 || response.status === 201) {
          this.getAlunos();
          this.aluno.nome = ""; 
          this.aluno.matricula = ""; 
          this.aluno.telefone = ""; 
          this.aluno.email = ""; 
          this.aluno.curso = ""; 
        } else {
          console.log("Erro ao salvar projeto:", response.data);
        }
      } catch (error) {
        console.log("Erro ao salvar projeto:", error);
      }
    },


    async excluirAluno(id) {
      try {
        const response = await axios.delete(`http://localhost:8080/alunos/${id}`)
      
        if (response.status === 200) {
          this.getAlunos();
        } else {
          console.log("ERRO", response.data);
        }
      } catch (e) {
        console.log("ERRO", e);
      }
    },
  }
};
</script>

<style scoped>
.container {
  max-width: 900px;
}
</style>