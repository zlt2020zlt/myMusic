import store from '@/store'

export default {
  inserted(el, binding, vnode) {
    const { value } = binding
    const authorities = store.getters && store.getters.authorities
    if (value && value instanceof Array && value.length > 0) {
      const permissionAuthoritys = value

      const hasPermission = authorities.some(authority => {
        return permissionAuthoritys.includes(authority.name)
      })

      if (!hasPermission) {
        el.parentNode && el.parentNode.removeChild(el)
      }
    } else {
      throw new Error(`使用方式： v-permission="['admin','editor']"`)
    }
  }
}
