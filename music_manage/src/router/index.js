import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: (resolve) => require(["../pages/login.vue"], resolve),
  },
  {
    path: "/Home",
    component: (resolve) => require(["../components/Home.vue"], resolve),
    children: [
      {
        path: "/Info",
        component: (resolve) => require(["../pages/InfoPage.vue"], resolve),
      },
      {
        path: "/Consumer",
        component: (resolve) => require(["../pages/ConsumerPage.vue"], resolve),
      },
      {
        path: "/Singer",
        component: (resolve) => require(["../pages/SingerPage.vue"], resolve),
      },
      {
        path: "/SongList",
        component: (resolve) => require(["../pages/SongListPage.vue"], resolve),
      },
    ],
  },
];

const router = new VueRouter({
  routes,
});

export default router;
