if (process.env.NODE_ENV !== "production") {
  require("dotenv").config();
}
module.exports = {
  PORT: process.env.PORT || 8085,
  MONGO_URL: process.env.MONGO_URL,
};
