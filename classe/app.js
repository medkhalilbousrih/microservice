const express = require("express");
const { errorHandler, unknownEndPoint } = require("./utils/basic-middleware");
const classeRouter = require("./controllers/classes");
const mongoose = require("mongoose");
const { MONGO_URL } = require("./utils/config");

const app = express();

mongoose
  .connect(MONGO_URL)
  .then((res) => console.log("connected to db"))
  .catch((err) => console.log(err.message));

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use("/api/classes", classeRouter);

app.use(unknownEndPoint);
app.use(errorHandler);

module.exports = app;
