const mongoose = require("mongoose");
const User = require("../models/user");
const connectToDb = require("../database")

const users = [
    {
        "username": "john_doe",
        "profile_pic": "pic0.png",
        "bio": "Nature lover and adventure seeker 🌿",
        "followers_count": 120,
        "following_count": 45
    },
    {
        "username": "sarah_smith",
        "profile_pic": "pic1.png",
        "bio": "Foodie and home chef 🍳",
        "followers_count": 300,
        "following_count": 150
    },
    {
        "username": "tech_guru",
        "profile_pic": "pic2.png",
        "bio": "Tech enthusiast and gadget reviewer 📱",
        "followers_count": 500,
        "following_count": 200
    },
    {
        "username": "travel_lover",
        "profile_pic": "pic3.png",
        "bio": "Exploring the world, one city at a time 🌍",
        "followers_count": 800,
        "following_count": 300
    },
    {
        "username": "fitness_freak",
        "profile_pic": "pic4.png",
        "bio": "Fitness coach and health advocate 💪",
        "followers_count": 1000,
        "following_count": 400
    },
    {
        "username": "bookworm",
        "profile_pic": "pic5.png",
        "bio": "Lost in the world of books 📚",
        "followers_count": 250,
        "following_count": 100
    },
    {
        "username": "foodie_queen",
        "profile_pic": "pic6.png",
        "bio": "Always on the hunt for the best food 🍣",
        "followers_count": 600,
        "following_count": 250
    },
    {
        "username": "pet_lover",
        "profile_pic": "pic7.png",
        "bio": "Proud dog mom 🐕",
        "followers_count": 400,
        "following_count": 150
    },
    {
        "username": "artistic_soul",
        "profile_pic": "pic8.png",
        "bio": "Painting my way through life 🎨",
        "followers_count": 350,
        "following_count": 120
    },
    {
        "username": "gamer_4_life",
        "profile_pic": "pic9.png",
        "bio": "Professional gamer and streamer 🎮",
        "followers_count": 1500,
        "following_count": 500
    }   
];



// Function to insert posts into the database
async function insertPosts() {
    try {
        // Connect to MongoDB
        await mongoose.connect("mongodb://localhost:27017/trying", {
            useNewUrlParser: true,
            useUnifiedTopology: true
        });
        console.log("Connected to MongoDB");

        // Insert posts into the database
        await User.insertMany(users);
        console.log("Posts inserted successfully");

        // Close the connection
        await mongoose.connection.close();
        console.log("Connection closed");
    } catch (err) {
        console.error("Error inserting posts:", err);
    }
}

// Run the function
insertPosts();