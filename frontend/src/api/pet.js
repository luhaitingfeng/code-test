import axios from 'axios'
import {baseUrl} from '@/const/urlconfig'

export const petList = (data) => {
    return axios.request({
        baseURL:baseUrl,
        url: '/api/petList.backend',
        data,
        method: 'get'
    })
}
