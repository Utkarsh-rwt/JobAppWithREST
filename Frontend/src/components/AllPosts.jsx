import React, { useEffect, useState } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import SearchIcon from '@mui/icons-material/Search';

import {
  Box,
    Card,
    Grid,
    InputAdornment,
    TextField,
    Typography,
  } from "@mui/material";
import { useNavigate } from 'react-router-dom';
import api from '../api';

const Search = () => {
    const [query, setQuery] = useState("");
    const [post, setPost] = useState([]);
    const [error, setError] = useState('');
    const navigate = useNavigate();

const handleEdit = (id) => {
  navigate("/edit",{state:{id}});
}

    useEffect(() => {
      let active = true;
      const fetchPosts = async () => {
        try {
          const endpoint = query.trim()
            ? `/jobPosts/search/${encodeURIComponent(query.trim())}`
            : '/jobPosts';
          const response = await api.get(endpoint);
          if (active) {
            setPost(response.data);
            setError('');
          }
        } catch {
          if (active) {
            setError('Could not load job posts. Make sure the backend is running on port 8080.');
          }
        }
      };
      fetchPosts();
      return () => {
        active = false;
      };
    }, [query]);

      const handleDelete = async (id) => {
        try {
          await api.delete(`/jobPost/${id}`);
          setPost((currentPosts) => currentPosts.filter((item) => item.postID !== id));
        } catch {
          setError('Could not delete this job post. Please try again.');
        }
      };

  return (
    <>
      <Grid container spacing={2} sx={{ margin: "2%" }}>
      <Grid item xs={12} sx={12} md={12} lg={12}>
      <Box>
          <TextField
            InputProps={{
              startAdornment: (
                <InputAdornment position="start">
                  <SearchIcon />
                </InputAdornment>
              ),
            }}
            placeholder="Search..."
            sx={{ width: "75%", padding: "2% auto" }}
            fullWidth
            onChange={(e) => setQuery(e.target.value)}
          />
        </Box>
      </Grid>
      {error && <Typography color="error" sx={{ m: 2 }}>{error}</Typography>}
      {post &&
        post.map((p) => {
          return (
            <Grid key={p.id} item xs={12} md={6} lg={4}>
              <Card sx={{ padding: "3%", overflow: "hidden", width: "84%", backgroundColor:"#ADD8E6" }}>
                <Typography
                  variant="h5"
                  sx={{ fontSize: "2rem", fontWeight: "600", fontFamily:"sans-serif" }}
                >
             {p.postProfile}
                </Typography>
                <Typography  sx={{ color: "#585858", marginTop:"2%", fontFamily:"cursive" }} variant="body" >
                  Description: {p.postDesc}
                </Typography>
                <br />
                <br />
                <Typography variant="h6" sx={{ fontFamily:"unset", fontSize:"400"}}>
                  Experience: {p.reqExperience} years
                </Typography>
                <Typography sx={{fontFamily:"serif",fontSize:"400"}} gutterBottom  variant="body">Skills : </Typography>
                {p.postTechStack.map((s, i) => {
                  return (
                    <Typography variant="body" gutterBottom key={i}>
                      {s} .
                      {` `}
                    </Typography>
                  );
                })}
               <DeleteIcon onClick={() => handleDelete(p.postID)} />
                <EditIcon onClick={() => handleEdit(p.postID)} />
              </Card>
            </Grid>
          );
        })}
    </Grid>
    </>

  )
}

export default Search
