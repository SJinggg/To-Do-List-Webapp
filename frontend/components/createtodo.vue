<template>
  <div class="create-container">
    <input v-model="newtodo" type="text">
    <button @click="addtodo">
      Add
    </button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      newtodo: ''
    }
  },
  methods: {
    addtodo () {
      this.$services.todo.create(this.newtodo).then((data) => {
        this.$emit('create', data)
        this.newtodo = '';
      })
    }
  }
}
</script>