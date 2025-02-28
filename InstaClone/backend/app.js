const express = require("express");
const bodyParser = require("body-parser");
const path = require("path");
const mongoose = require("mongoose")
const Post = require("./models/post")
const User = require("./models/user")

const app = express();



app.use(bodyParser.json());
app.use(express.static(path.join(__dirname, "public")));


app.get("/posts", async (req, res) => {
    try {
        const data = await Post.find({})
        res.status(200).json(data)
    } catch (e) {
        console.log(e)
        res.status(200).send("error")
    }
});

app.get("/user/:name", async (req, res) => {
    try {
        const user = await User.findOne({username: req.params.name})
        res.status(200).json(user)
    } catch (e) {
        console.log(e)
        res.status(500).send("error")
    }
})

const connectToDb = require("./database");

connectToDb(() => {
  app.listen(3001, () => {
    console.log(`server listening on : 3001`);
  });
});