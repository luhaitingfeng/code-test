import axios from 'axios'

let petListApi = "api/petList";

export const petList = (data) => {
    return axios.request({
        url: '/api/petList',
        data,
        method: 'post'
    })
}
