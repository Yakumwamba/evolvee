
<template>
  <div v-if="initialized">
    <SpWallet ref="wallet" v-on:dropdown-opened="$refs.menu.closeDropdown()" />
    <SpLayout>
      <template v-slot:sidebar>
        <Sidebar />
      </template>
      <template v-slot:chat>
        <Chat />
      </template>
      <template v-slot:content>
        <router-view />
      </template>
    </SpLayout>
  </div>
</template>

<style>
body {
  margin: 0;
}
</style>

<script>
import './scss/app.scss'
import '@starport/vue/lib/starport-vue.css'
import Sidebar from './components/Sidebar'
import { VuePlugin } from 'vuera'
import { Vue } from 'vue'

import Chat from './evolvee_client/src/ui/messenger/Chat.tsx'

import evolvee from './evolvee_client/src/ui/EvolveeUI.tsx'

function vue(Vue) {
  Vue.use(VuePlugin);
}

export default {
  components: {
    Sidebar,
    evolvee,
    Chat
  },
  data() {
    return {
      initialized: false,
    }
  },
  computed: {
    hasWallet() {
      return this.$store.hasModule(['common', 'wallet'])
    },
  },
  async created() {
    await this.$store.dispatch('common/env/init')
    this.initialized = true
  },
  errorCaptured(err) {
    console.log(err)
    return false
  },
}
</script>
