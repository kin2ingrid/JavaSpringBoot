import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';
import { blue } from '@mui/material/colors';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';




export default function Produits() {
  const paperStyle={padding: '50px 20px', width:600, margin:"20px auto"}
  const [name, SetName] = React.useState('')
  const [description, setDescription] = React.useState('')
  const [price, setPrice] = React.useState('')
  const [produits, setProduits] = React.useState([])
  const handleClick=(e)=> {
    e.preventDefault()
      const produit={name, description, price}
      console.log(produit)
  
    fetch("http://localhost:8083/produit/ajouter",
      {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body:JSON.stringify(produits)
      
    }).then(()=>{
      console.log("Produit ajouter avec succes")
    })
    }

    React.useEffect(()=>{
      fetch("http://localhost:8083/produit/liste")
      .then(res=> res.json())
      .then((result)=>{
        setProduits(result);
        })
    }, [])



  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{color: blue}}>Ajouter un produit</h1>
    <Box
      component="form"
      sx={{ '& > :not(style)': { m: 1, width: '25ch' } }}
      noValidate
      autoComplete="off"
    >
      <TextField id="outlined-basic" label="Nom" variant="outlined" fullWidth
      value={name}
      onChange={(e)=>SetName(e.target.value)}/>
      <TextField id="outlined-basic" label="Description" variant="outlined" fullWidth
      value={description}
      onChange={(e)=>setDescription(e.target.value)}/>
      <TextField id="outlined-basic" label="Prix" variant="outlined" fullWidth
      value={price}
      onChange={(e)=>setPrice(e.target.value)}/>
<br></br>
      <Button variant="contained" onClick={handleClick}>Ajouter</Button>
     
    </Box>
    
    </Paper>

    
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            {/* <TableCell></TableCell> */}
            <TableCell align="right">Id</TableCell>
            <TableCell align="right">Nom</TableCell>
            <TableCell align="right">Description</TableCell>
            <TableCell align="right">Prix</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {produits.map((produit) => (
            <TableRow
              key={produit.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {produit.id}
              </TableCell>
              <TableCell align="right">{produit.name}</TableCell>
              <TableCell align="right">{produit.description}</TableCell>
              <TableCell align="right">{produit.price}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>

    </Container>
  );
}



    