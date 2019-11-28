<template>
    <div style="text-align: left;margin:0 auto;width:200px; ">
        <h2>Code Test – Pets</h2>
        <div v-for="(item,index) in pets" :key="index" >
            {{item.gender}}
            <div v-for="(cat,index2) in item.names" :key="index2">--{{cat}}</div>
        </div>
    </div>
</template>

<script>
    import { petList } from '@/api/pet'
    export default {
        name: 'pet',
        data(){
            return {
                pets:[{
                    gender:'',
                    names:[]
                }]
            }
        },
        mounted(){
            this.intPet();
        },
        methods:{
            intPet(){
                petList().then(res => {
                    let result = res.data
                    if (result && result.success) {
                        this.pets = result.data
                    }
                })
            },
        }
    }
</script>

<style>
</style>
