import React, { useEffect, useState } from "react";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import api from '../api';

const initial = {
  postId: "",
  postProfile: "",
  reqExperience: 0,
  postTechStack: [],
  postDesc: "",
};

const Edit = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [form, setForm] = useState(initial);
  const [error, setError] = useState('');
  const currId = location.state?.id;


  useEffect(() => {
    if (!currId) {
      navigate('/');
      return;
    }
    const fetchPost = async () => {
      try {
        const response = await api.get(`/jobPost/${currId}`);
        setForm(response.data);
      } catch {
        setError('Could not load this job post. Make sure the backend is running and try again.');
      }
    };
    fetchPost();
  }, [currId, navigate]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.put('/jobPost', {
        ...form,
        reqExperience: Number(form.reqExperience),
      });
      navigate('/');
    } catch {
      setError('Could not update this job post. Make sure the backend is running and try again.');
    }
  };

  const handleSkillChange = (e) => {
    const { checked, value } = e.target;
    setForm((currentForm) => ({
      ...currentForm,
      postTechStack: checked
        ? [...currentForm.postTechStack, value]
        : currentForm.postTechStack.filter((skill) => skill !== value),
    }));
  };

  const skillSet = [
    {
      name: "Javascript",
    },
    {
      name: "Java",
    },
    {
      name: "Python",
    },
    {
      name: "Django",
    },
    {
      name: "Rust",
    },
  ];

  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align="center" variant="h5">
        Edit New Post
      </Typography>
      <form autoComplete="off" noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={(e) => setForm({ ...form, postId: e.target.value })}
            label="Enter your Post ID"
            variant="outlined"
            value={form.postId}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
            label="Job-Profile"
            variant="outlined"
            value={form.postProfile}
          />
          <TextField
            min="0"
            type="number"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) =>
              setForm({ ...form, reqExperience: e.target.value })
            }
            label="Years of Experience"
            variant="outlined"
            value={form.reqExperience}
          />
          <TextField
            type="string"
            sx={{ width: "50%", margin: "2% auto" }}
            required
            multiline
            rows={4}
            onChange={(e) => setForm({ ...form, postDesc: e.target.value })}
            label="Job-desc"
            variant="outlined"
            value={form.postDesc}
          />
          <Box sx={{ margin: "1% auto" }}>
            <h3>Please mention required skills</h3>
            <ul>
              {skillSet.map(({ name }, index) => {
                return (
                  <li key={index}>
                    <div>
                      <div>
                        <input
                          type="checkbox"
                          id={`custom-checkbox-${index}`}
                          name={name}
                          value={name}
                          checked={form.postTechStack.includes(name)}
                          onChange={handleSkillChange}
                        />
                        <label htmlFor={`custom-checkbox-${index}`}>
                          {name}
                        </label>
                      </div>
                    </div>
                  </li>
                );
              })}
            </ul>
          </Box>
          {error && <Typography color="error" sx={{ width: "50%", margin: "0 auto" }}>{error}</Typography>}
          <Button
            sx={{ width: "50%", margin: "2% auto" }}
            variant="contained"
            type="submit"

          >
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Edit;
