const mongoose = require("mongoose");

const userSchema = mongoose.Schema(
  {
    username: {
      type: String,
    },
    profile_pic: {
      type: String,
      default: null,
    },
    bio: {
        type: String,
    },
    followers_count: {
      type: Number,
      default: 0
    },
    following: {
      type: Number,
      default: 0
    },
  },
  { timestamps: true }
);

const User = mongoose.model("user", userSchema);

module.exports = User;