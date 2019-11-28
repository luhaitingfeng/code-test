import axios from 'axios'
import {baseUrl} from '@/const/urlconfig'

export const cityList = (data) => {
    return axios.request({
        baseURL:baseUrl,
        url: '/api/cities.backend',
        data,
        method: 'get'
    })
}
export const cityWeather = (data) => {
    return axios.request({
        baseURL:baseUrl,
        url: '/api/cityWeather.backend',
        data,
        method: 'post'
    })
}
