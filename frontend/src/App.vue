<template>
  <div id="app">
    <div>
      <router-link to="/pet">Go to Pet</router-link>
      <router-link to="/weather" style="margin-left: 10px;">Go to Weather</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
