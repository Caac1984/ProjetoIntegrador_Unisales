<template>
  <div class="container-fluid mb-3 p-3 bg">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" id="navmenu">
      <a href="/">
        <img src="@/assets/logo.png" ref="../src/views/homeview" alt="Logo" class="navbar-brand" />
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/" class="nav-link" active-class="active">Início</router-link>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              cadastros
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><router-link to="/alunos/cadastrar" class="dropdown-item">Cadastrar Aluno</router-link></li>
              <li><router-link to="/professores/cadastrar" class="dropdown-item">Cadastrar Professor</router-link></li>
              <li><router-link to="/cursos/cadastrar" class="dropdown-item">Cadastrar Curso</router-link></li>
              <li><router-link to="/visitantes/cadastrar" class="dropdown-item">Cadastrar Visitante</router-link></li>
              <li><router-link to="/grupos/cadastrar" class="dropdown-item">Cadastrar Grupo</router-link></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownProf" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Listas
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownProf">
              <li><router-link to="/alunos" class="dropdown-item">Lista de Alunos</router-link></li>
              <li><router-link to="/professores" class="dropdown-item">Lista de Professores</router-link></li>
              <li><router-link to="/cursos" class="dropdown-item">Lista de Cursos</router-link></li>
              <li><router-link to="/visitantes" class="dropdown-item">Lista de Visitantes</router-link></li>
              <li><router-link to="/grupos" class="dropdown-item">Lista de Grupos</router-link></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownProf" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Avaliações e Notas
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownProf">
              <li><router-link to="/avaliacao" class="dropdown-item">Avaliação</router-link></li>
            </ul>
          </li>
          
        </ul>
        <div class="deslogar navbar-brand">
          <div class="log-user ">{{ logado.login }}</div> | <button class="btn btn-primary" @click="desloga">Sair</button>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
import LoginService from "@/services/LoginService";
import AuthService from "@/services/AuthService";

export default {
  methods: {
    desloga() {
      LoginService.deslogar();
      this.$router.push(`/?d=${new Date()}`);
    },
  },
  computed: {
    logado() {
      return AuthService.dados;
    },
  },
};
</script>

<style scoped>

#navmenu {
 text-align: center;
}

button {
  margin: 0 10px;
}

.navbar {
  border-radius: 10px;
  font-size: 18px;
}

.navbar-brand {
  width: 130px;
  height: 40px;
  margin-right: 50px;
  margin-left: 20px;
}

.nav-item {
  margin-right: 10px;
  /* Espaçamento entre os itens do menu */
}

.deslogar {
  margin-left: auto;
  display: flex;
  align-items: center;
  margin-right: 20px;
}

button:hover {
  color: black;
}

.log-user {
  font-weight: bold;
  font-family: Helvetica;
  text-transform: uppercase;
  font-size: 19px;
  color: rgb(17, 0, 255);
}

</style>