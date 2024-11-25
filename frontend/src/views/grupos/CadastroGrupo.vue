<template>
  <barra-navegacao></barra-navegacao>

  <div class="cadastro">
    <div class="row g-0 justify-content-center">
      <div class="col-lg-6 col-md-6 col-sm-8">
        <div class="card">
          <h1>Cadastro de Grupo</h1>
          <form @submit.prevent="salvar">
            <div class="row gx-3 gy-2 align-items-center p-2">
              <div class="col-sm-3">
                <input
                  v-model="grupo.trabalho"
                  type="text"
                  class="form-control"
                  placeholder="Nome do Trabalho"
                  required
                />
              </div>
              <div class="col-sm-3">
                <input
                  v-model="grupo.descricao"
                  type="text"
                  class="form-control"
                  placeholder="Descrição"
                  required
                />
              </div>
            </div>
            <div class="row gx-3 gy-2 align-items-center p-2">
              <div class="col-sm-3">
                <input
                  v-model="grupo.matricula"
                  type="text"
                  class="form-control"
                  placeholder="Matricula"
                  required
                />
              </div>
            </div>
            <div class="d-grid gap-2 d-md-block bots">
              <button type="submit" class="btn btn-primary">Salvar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BarraNavegacao from "@/components/BarraNavegacao.vue";
import AuthService from "@/services/AuthService";
import axios from "axios";

export default {
  components: {
    BarraNavegacao,
  },
  data() {
    return {
      grupo: {
        trabalho: "",
        descricao: "",
        matricula: "",
      },
    };
  },
  methods: {
    async salvar() {
      try {
        const response = await axios.post(
          "http://localhost:8080/grupos",
          this.grupo,
          {
            headers: {
              Authorization: `Bearer ${AuthService.dados.token}`,
              "Content-Type": "application/json",
            },
          }
        );
        if (response.status === 200 || response.status === 201) {
          alert("Grupo cadastrado com sucesso!");
          this.grupo.nome = "";
          this.grupo.descricao = "";
        } else {
          console.log("Erro ao salvar grupo:", response.data);
        }
      } catch (error) {
        console.log("Erro ao salvar grupo:", error);
      }
    },
  },
};
</script>

<style scoped>
.card {
  padding: 20px;
}
</style>
