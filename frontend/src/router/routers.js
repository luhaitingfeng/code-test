export default [
    {
        path: '/pet',
        component: () => import('@/view/pet.vue')
    },
    {
        path: '/weather',
        component: () => import('@/view/weather.vue')
    },
]
