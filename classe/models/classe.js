const mongoose = require("mongoose");

const classeSchema = new mongoose.Schema({
  classeId: {
    type: Number,
    unique: true,
  },
  option: {
    type: String,
  },
  niveau: {
    type: Number,
  },
  description: {
    type: String,
  },
});

classeSchema.set("toJSON", {
  transform: (obj, newObj) => {
    newObj.id = newObj._id.toString();
    delete newObj._id;
    delete newObj.__v;
  },
});

module.exports = mongoose.model("Classe", classeSchema);
