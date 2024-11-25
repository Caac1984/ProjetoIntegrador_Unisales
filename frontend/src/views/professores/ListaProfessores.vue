<template>
  <barra-navegacao></barra-navegacao>

  <div class="lista">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
          <h1>Lista de Professores</h1>
          <table class="table table-striped table-primary">
            <thead class="table-dark">
              <tr>
                <th>Nome</th>
                <th>Email</th>
                <th>Disciplina</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="professor in professores" :key="professor.id">
                <td>{{ professor.nome }}</td>
                <td>{{ professor.email }}</td>
                <td>{{ professor.disciplina }}</td>
                <td>
                  <button class="btn btn-primary btn-sm" @click="editarProfessor(professor.id)">Editar</button>
                  <button class="btn btn-danger btn-sm" @click="excluirProfessor(professor.id)">Excluir</button>
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
      professores: [],
    };
  },
  mounted() {
    this.getProfessores();
  },
  methods: {
    async getProfessores() {
      try {
        const response = await axios.get("http://localhost:8080/professores");
        this.professores = response.data;
      } catch (error) {
        console.error("Erro ao buscar professores:", error);
      }
    },
    editarProfessor(id) {
      this.$router.push(`/professores/editar/${id}`);
    },
    async excluirProfessor(id) {
      try {
        await axios.delete(`http://localhost:8080/professores/${id}`);
        this.getProfessores();
      } catch (error) {
        console.error("Erro ao excluir professor:", error);
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