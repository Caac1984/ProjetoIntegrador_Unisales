<template>
  <barra-navegacao></barra-navegacao>

  <div class="lista">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
          <h1>Lista de Cursos</h1>
          <table class="table table-striped table-primary">
            <thead class="table-dark">
              <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Duração</th>
                <th>Ações</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="curso in cursos" :key="curso.id">
                <td>{{ curso.nome }}</td>
                <td>{{ curso.descricao }}</td>
                <td>{{ curso.duracao }} horas</td>
                <td>
                  <button class="btn btn-primary btn-sm" @click="editarCurso(curso.id)">Editar</button>
                  <button class="btn btn-danger btn-sm" @click="excluirCurso(curso.id)">Excluir</button>
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
      cursos: [],
    };
  },
  mounted() {
    this.getCursos();
  },
  methods: {
    async getCursos() {
      try {
        const response = await axios.get("http://localhost:8080/cursos");
        this.cursos = response.data;
      } catch (error) {
        console.error("Erro ao buscar cursos:", error);
      }
    },
    editarCurso(id) {
      this.$router.push(`/cursos/editar/${id}`);
    },
    async excluirCurso(id) {
      try {
        await axios.delete(`http://localhost:8080/cursos/${id}`);
        this.getCursos();
      } catch (error) {
        console.error("Erro ao excluir curso:", error);
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