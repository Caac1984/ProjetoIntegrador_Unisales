<template>
  <barra-navegacao></barra-navegacao>

  <div class="lista">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
          <h1>Lista de Alunos</h1>
          <table class="table table-striped table-primary">
            <thead class="table-dark">
              <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Curso</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="aluno in alunos" :key="aluno.id">
                <td>{{ aluno.nome }}</td>
                <td>{{ aluno.email }}</td>
                <td>{{ aluno.curso }}</td>
                <td>
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
      } catch (error) {
        console.error("Erro ao buscar alunos:", error);
      }
    },
    editarAluno(id) {
      this.$router.push(`/alunos/editar/${id}`);
    },
    async excluirAluno(id) {
      try {
        await axios.delete(`http://localhost:8080/alunos/${id}`);
        this.getAlunos();
      } catch (error) {
        console.error("Erro ao excluir aluno:", error);
      }
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 900px;
}
</style>