<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="container mt-4">
      <h1>Editar Visitante</h1>
      <form @submit.prevent="atualizarVisitante">
        <div class="mb-3">
          <label for="nome" class="form-label">Nome</label>
          <input v-model="visitante.nome" type="text" id="nome" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input v-model="visitante.email" type="email" id="email" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="empresa" class="form-label">Empresa</label>
          <input v-model="visitante.empresa" type="text" id="empresa" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
      </form>
    </div>
  </template>
  
  <script>
  import BarraNavegacao from "@/components/BarraNavegacao.vue";
  import axios from "axios";
  
  export default {
    components: { BarraNavegacao },
    data() {
      return {
        visitante: {
          nome: "",
          email: "",
          empresa: "",
        },
      };
    },
    mounted() {
      this.getVisitante();
    },
    methods: {
      async getVisitante() {
        try {
          const response = await axios.get(`http://localhost:8080/visitantes/${this.$route.params.id}`);
          this.visitante = response.data;
        } catch (error) {
          console.error("Erro ao buscar visitante:", error);
        }
      },
      async atualizarVisitante() {
        try {
          await axios.put(`http://localhost:8080/visitantes/${this.$route.params.id}`, this.visitante);
          alert("Visitante atualizado com sucesso!");
          this.$router.push("/visitantes");
        } catch (error) {
          console.error("Erro ao atualizar visitante:", error);
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .container {
    max-width: 600px;
  }
  </style>
  