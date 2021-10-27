const http = require("http");
const logger = require("./utils/logger");
const { PORT } = require("./utils/config");
const app = require("./app");
const Eureka = require("eureka-js-client").Eureka;
const server = http.createServer(app);

server.listen(PORT, () => {
  logger.info("server running on port", PORT);
});

const client = new Eureka({
  // application instance information
  instance: {
    app: "classe-service",
    hostName: "classe-service",
    ipAddr: "127.0.0.1",
    port: {
      $: 8085,
      "@enabled": "true",
    },
    vipAddress: "classe-service",
    dataCenterInfo: {
      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
      name: "MyOwn",
    },
    registerWithEureka: true,
    fetchRegistry: true,
  },
  eureka: {
    // eureka server host / port
    host: "eureka-server",
    port: 8761,
    servicePath: "/eureka/apps",
    maxRetries: 10,
    requestRetryDelay: 5000,
  },
});

client.start((error) => {
  if (error) {
    console.log(error);
  } else {
    console.log("Successfully connected to eureka client");
  }
});

process.on("SIGINT", async () => {
  client.stop(() => {
    process.exit();
  });
});
