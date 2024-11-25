<template>
    <div>
      <barra-navegacao></barra-navegacao> <!-- Barra de navegação -->
  
      <div class="cadastro">
        <div class="row g-0 justify-content-center">
          <div class="col-lg-6">
            <div class="card">
              <h1>Cadastro de Curso</h1>
              <form @submit.prevent="salvarCurso">
                <!-- Nome do Curso -->
                <div class="row gx-3 gy-2 align-items-center p-2">
                  <div class="col-sm-3">
                    <input
                      v-model="curso.nome"
                      type="text"
                      class="form-control"
                      placeholder="Nome do Curso"
                      required
                    />
                  </div>
              
  
                <!-- Descrição -->
                
                  <div class="col-sm-3">
                    <input
                      v-model="curso.descricao"
                      type="text"
                      class="form-control"
                      placeholder="Descrição"
                    />
                  </div>
                </div>
  
                <!-- Botão -->
                <div class="d-grid gap-2 d-md-block bots">
                  <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
              </form>
            </div>
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
        curso: {
          nome: "",
          descricao: "",
        },
      };
    },
    methods: {
      async salvarCurso() {
        try {
          const response = await axios.post("http://localhost:8080/cursos", this.curso);
          if (response.status === 201) {
            alert("Curso cadastrado com sucesso!");
            this.$router.push("/cursos"); // Redireciona para a lista de cursos após salvar
          }
        } catch (error) {
          console.error("Erro ao salvar curso:", error);
        }
      },
    },
  };
  </script>
  