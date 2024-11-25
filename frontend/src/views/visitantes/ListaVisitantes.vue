<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="lista">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-9 col-md-6 col-sm-8">
        <div class="card">
      <h1>Lista de Visitantes</h1>
      <table class="table table-striped table-primary">
        <thead class="table-dark">
          <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Empresa</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="visitante in visitantes" :key="visitante.id">
            <td>{{ visitante.nome }}</td>
            <td>{{ visitante.email }}</td>
            <td>{{ visitante.empresa }}</td>
            <td>
              <button class="btn btn-primary btn-sm" @click="editarVisitante(visitante.id)">Editar</button>
              <button class="btn btn-danger btn-sm" @click="excluirVisitante(visitante.id)">Excluir</button>
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
        visitantes: [],
      };
    },
    mounted() {
      this.getVisitantes();
    },
    methods: {
      async getVisitantes() {
        try {
          const response = await axios.get("http://localhost:8080/visitantes");
          this.visitantes = response.data;
        } catch (error) {
          console.error("Erro ao buscar visitantes:", error);
        }
      },
      editarVisitante(id) {
        this.$router.push(`/visitantes/editar/${id}`);
      },
      async excluirVisitante(id) {
        try {
          await axios.delete(`http://localhost:8080/visitantes/${id}`);
          this.getVisitantes();
        } catch (error) {
          console.error("Erro ao excluir visitante:", error);
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
  