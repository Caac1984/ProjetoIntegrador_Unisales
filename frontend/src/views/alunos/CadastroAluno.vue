<template>
  <div>
    <barra-navegacao></barra-navegacao> <!-- Barra de navegação -->

    <div class="cadastro">
      <div class="row g-0 justify-content-center">
        <div class="col-lg-6">
          <div class="card">
            <h1>Cadastro de Aluno</h1>
            <form @submit.prevent="salvarAluno">
              <!-- Nome -->
              <div class="row gx-3 gy-2 align-items-center p-2">
                <div class="col-sm-3">
                  <input
                    v-model="aluno.nome"
                    type="text"
                    class="form-control"
                    placeholder="Nome"
                    required
                  />
                </div>


              <!-- Matricula -->
           
              <div class="col-sm-3">
                  <input
                    v-model="aluno.matricula"
                    type="matricula"
                    class="form-control"
                    placeholder="Matricula"
                    required
                  />
                </div>
              </div>
                 <!-- Telefone -->
                 <div class="row gx-3 gy-2 align-items-center p-2">
              <div class="col-sm-3">
                  <input
                    v-model="aluno.telefone"
                    type="telefone"
                    class="form-control"
                    placeholder="Telefone"
                    required
                  />
                </div>
             

              <!-- Email -->
           
                <div class="col-sm-3">
                  <input
                    v-model="aluno.email"
                    type="email"
                    class="form-control"
                    placeholder="Email"
                    required
                  />
                </div>
                 </div>

              <!-- Curso -->
              <div class="row gx-3 gy-2 align-items-center p-2">
                <div class="col-sm-3">
                  <input
                    v-model="aluno.curso"
                    type="text"
                    class="form-control"
                    placeholder="Curso"
                    required
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
      aluno: {
        nome: "",
        matricula: "",
        telefone: "",
        email: "",
        curso: "",
      },
    };
  },
  methods: {
    async salvarAluno() {
  console.log('Enviando dados do aluno:', this.aluno); // Verifique os dados antes de enviar

  try {
    const response = await axios.post("http://localhost:8080/alunos", this.aluno);
    if (response.status === 201) {
      alert("Aluno cadastrado com sucesso!");
      this.$router.push("/alunos");
    }
  } catch (error) {
    console.error("Erro ao salvar aluno:", error);
    alert("Erro ao salvar aluno.");
      }
    },
  },
};
</script>
