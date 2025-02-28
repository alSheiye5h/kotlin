const mongoose = require("mongoose");
const Post = require("../models/post");
const connectToDb = require("../database")

const posts = [
    {
        "username": "john_doe",
        "title": "Exploring the mountains this weekend!",
        "image": ["image0.png"],
        "likes_count": 45,
        "comments_count": 18
    },
    {
        "username": "sarah_smith",
        "title": "Homemade pasta for dinner tonight!",
        "image": ["image1.png"],
        "likes_count": 120,
        "comments_count": 56
    },
    {
        "username": "tech_guru",
        "title": "Just got the new iPhone 15!",
        "image": ["image2.png"],
        "likes_count": 300,
        "comments_count": 89
    },
    {
        "username": "travel_lover",
        "title": "Sunset at the beach 🌅",
        "image": ["image3.png"],
        "likes_count": 250,
        "comments_count": 67
    },
    {
        "username": "fitness_freak",
        "title": "Morning workout done! 💪",
        "image": ["image4.png"],
        "likes_count": 89,
        "comments_count": 34
    },
    {
        "username": "bookworm",
        "title": "Just finished reading 'The Alchemist'!",
        "image": ["image5.png"],
        "likes_count": 78,
        "comments_count": 22
    },
    {
        "username": "foodie_queen",
        "title": "Tried the new sushi place in town!",
        "image": ["image6.png"],
        "likes_count": 150,
        "comments_count": 45
    },
    {
        "username": "pet_lover",
        "title": "My dog enjoying the park! 🐕",
        "image": ["image7.png"],
        "likes_count": 200,
        "comments_count": 60
    },
    {
        "username": "artistic_soul",
        "title": "Finished my latest painting! 🎨",
        "image": ["image8.png"],
        "likes_count": 95,
        "comments_count": 30
    },
    {
        "username": "gamer_4_life",
        "title": "Just reached level 100 in my favorite game!",
        "image": ["image9.png"],
        "likes_count": 400,
        "comments_count": 120
    }
];


// Function to insert posts into the database
async function insertPosts() {
    try {
        // Connect to MongoDB
        await connectToDb(() => {
            Post.insertMany(posts)
        })
        console.log("Connected to MongoDB");

        // Insert posts into the database
        await Post.insertMany(posts);
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