<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="container mt-4">
      <h1>Editar Professor</h1>
      <form @submit.prevent="atualizarProfessor">
        <div class="mb-3">
          <label for="nome" class="form-label">Nome</label>
          <input v-model="professor.nome" type="text" id="nome" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="email" class="form-label">Email</label>
          <input v-model="professor.email" type="email" id="email" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="disciplina" class="form-label">Disciplina</label>
          <input v-model="professor.disciplina" type="text" id="disciplina" class="form-control" required />
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
        professor: {
          nome: "",
          email: "",
          disciplina: "",
        },
      };
    },
    mounted() {
      this.getProfessor();
    },
    methods: {
      async getProfessor() {
        try {
          const response = await axios.get(`http://localhost:8080/professores/${this.$route.params.id}`);
          this.professor = response.data;
        } catch (error) {
          console.error("Erro ao buscar professor:", error);
        }
      },
      async atualizarProfessor() {
        try {
          await axios.put(`http://localhost:8080/professores/${this.$route.params.id}`, this.professor);
          alert("Professor atualizado com sucesso!");
          this.$router.push("/professores");
        } catch (error) {
          console.error("Erro ao atualizar professor:", error);
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
  