<template>
    <div>
        <h2>Get Current Weather</h2>
        <select v-model="selectCity" placeholder="Select your city" @change="findCityWeather">
            <Option value="" key="none">none</Option>
            <Option v-for="item in cities" :value="item" :key="item">{{ item }}</Option>
        </select>

        <div v-if="selectCity">
            <div>city: {{form.city}}</div>
            <div>weather: {{form.weather}}</div>
            <div>temperature: {{form.temperature}}</div>
            <div>wind: {{form.wind}}</div>
            <div>updateTime: {{form.updateTime}}</div>
        </div>
    </div>
</template>

<script>
    import { cityList, cityWeather } from '@/api/weather'
    export default {
        name: 'weather',
        data(){
            return {
                selectCity:'',
                cities:[],
                form:{
                    city:'',
                    updateTime:'',
                    weather:'',
                    temperature:'',
                    wind:'',
                }
            }
        },
        mounted(){
            this.initCity();
        },
        methods:{
            initCity(){
                cityList().then(res => {
                    let result = res.data
                    if (result && result.success) {
                        this.cities = result.data
                    }
                })
            },
            findCityWeather(){
                if(this.selectCity){
                    cityWeather({city:this.selectCity}).then(res => {
                        let result = res.data
                        if (result && result.success) {
                            this.form = result.data
                        }
                    })
                }
            }
        }
    }
</script>

<style>
</style>
