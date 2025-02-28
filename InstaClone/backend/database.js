const mongoose = require("mongoose");

const connectToDb = async (callback) => {
  try {
    const baseConnection = await mongoose.connect(
      "mongodb://localhost:27017/trying"
    );
    callback();
  } catch (error) {
    console.log("database Error :", error);
  }
};

module.exports = connectToDb;