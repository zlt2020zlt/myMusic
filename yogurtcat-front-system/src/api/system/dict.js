import request from '@/utils/request'

export function list(params) {
  return request({
    url: 'dictionary/list',
    method: 'get',
    params
  })
}

export function add(data) {
  return request({
    url: 'dictionary/create',
    method: 'post',
    data
  })
}

export function del(ids) {
  return request({
    url: 'dictionary/delete',
    method: 'delete',
    data: ids
  })
}

export function edit(data) {
  return request({
    url: 'dictionary/update',
    method: 'put',
    data
  })
}

export default { add, edit, del }
