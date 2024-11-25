<template>
    <barra-navegacao></barra-navegacao>
  
    <div class="container mt-4">
      <h1>Editar Curso</h1>
      <form @submit.prevent="atualizarCurso">
        <div class="mb-3">
          <label for="nome" class="form-label">Nome do Curso</label>
          <input v-model="curso.nome" type="text" id="nome" class="form-control" required />
        </div>
        <div class="mb-3">
          <label for="descricao" class="form-label">Descrição</label>
          <input v-model="curso.descricao" type="text" id="descricao" class="form-control" />
        </div>
        <div class="mb-3">
          <label for="duracao" class="form-label">Duração (em horas)</label>
          <input v-model="curso.duracao" type="number" id="duracao" class="form-control" required />
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
        curso: {
          nome: "",
          descricao: "",
          duracao: "",
        },
      };
    },
    mounted() {
      this.getCurso();
    },
    methods: {
      async getCurso() {
        try {
          const response = await axios.get(`http://localhost:8080/cursos/${this.$route.params.id}`);
          this.curso = response.data;
        } catch (error) {
          console.error("Erro ao buscar curso:", error);
        }
      },
      async atualizarCurso() {
        try {
          await axios.put(`http://localhost:8080/cursos/${this.$route.params.id}`, this.curso);
          alert("Curso atualizado com sucesso!");
          this.$router.push("/cursos");
        } catch (error) {
          console.error("Erro ao atualizar curso:", error);
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
  