<template>
  <div>
    <h1>Prospects</h1>
    <router-link
      :to="{
        name: 'detail',
        params: {
          prospect: prospect,
        },
      }"
      v-for="prospect in prospectsList"
      v-bind:key="prospect.id"
    >
      <h2>{{ prospect.firstName }} {{ prospect.lastName }}</h2></router-link
    >
  </div>
</template>

<script>
import ProspectService from "../services/ProspectService";
export default {
  data() {
    return {
      prospectsList: [],
    };
  },
  created() {
    ProspectService.getAllProspects().then((response) => {
      this.prospectsList = response.data;
    });
  },
};
</script>

<style>
</style>