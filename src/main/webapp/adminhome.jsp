<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        background-color: #f2f2f2;
        font-family: Arial, sans-serif;
    }
    
    form {
        width: 70%px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        animation: slide-up 0.5s ease-in-out;
    }
    
    @keyframes slide-up {
        0% {
            opacity: 0;
            transform: translateY(10px);
        }
        100% {
            opacity: 1;
            transform: translateY(0);
        }
    }
    
    p {
        font-size: 16px;
        margin-bottom: 20px;
    }
    
    table {
        width: 100%;
        margin-bottom: 20px;
        border-collapse: collapse;
    }
    
    th {
        background-color: #f2f2f2;
        padding: 10px;
        text-align: left;
    }
    
    td {
        padding: 10px;
        border-bottom: 1px solid #ccc;
    }
    
    input[type="text"],
    input[type="file"],
    input[type="radio"] {
        width: 100%;
        padding: 8px;
        font-size: 14px;
        border: 1px solid #ccc;
        border-radius: 4px;
        transition: border-color 0.3s;
    }
    
    input[type="text"]:focus,
    input[type="file"]:focus,
    input[type="radio"]:focus {
        outline: none;
        border-color: #007bff;
    }
    
    .materiel_sending {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }
    
    .sender1,
    .sender2,
    .sender3,
    .sender4,
    .sender5 {
        flex-basis: 16%;
    }
    
    input[type="submit"] {
        display: inline-block;
        padding: 8px 16px;
        font-size: 14px;
        text-align: center;
        text-decoration: none;
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 4px;
        transition: background-color 0.3s;
        cursor: pointer;
    }
    
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
        <form action="ControllerAdmin" method="post" enctype="multipart/form-data">
            <p>Ajouter un materiel:</p>
            <div class="materiel_info_container">
                    <table>
                        <thead>
                            <tr>
                                <th>Infos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Nom:</td>
                                <td><input type="text" name="nom" placeholder="Nom du materiel"></td>
                            </tr>
                            <tr>
                                <td>Description:</td>
                                <td><input type="text" name="description" placeholder="decrire le materiel"></td>
                            </tr>
                            <tr>
                                <td>Prix (euro):</td>
                                <td><input type="text" name="prix" placeholder="prix du materiel"></td>
                            </tr>
							<tr> 
								<td> Image: </td>
								<td> 
									<input type="file" id="image" name="image" required>
								</td>
							</tr>
                        </tbody>
                    </table>
            </div>
            
            <div class="materiel_sending">
                <div class="sender1">
                    <label for="name">Ordinateur:</label>
                    <input type="radio" name="typemateriel" value="Ordinateur">
                </div>
                <div class="sender2">
                    <label for="name">Telephone:</label>
                    <input type="radio" name="typemateriel" value="Telephone">
                </div>
                <div class="sender3">
                    <label for="name">Tablette:</label>
                    <input type="radio" name="typemateriel" value="Tablette">
                </div>
                <div class="sender3">
                    <label for="name">Camera:</label>
                    <input type="radio" name="typemateriel" value="Camera">
                </div>
                <div class="sender4">
                    <label for="name">Imprimante:</label>
                    <input type="radio" name="typemateriel" value="Imprimante">
                </div>
                <div class="sender5">
                    <label for="name">Television:</label>
                    <input type="radio" name="typemateriel" value="Television">
                </div>
                    <input type="submit" name="operation"  value="ajouterMateriel">
                
            </div>

        </form>
                <form action="ControllerAdmin" method="post" enctype="multipart/form-data">
                    <input type="submit" name="operation"  value="ListerMatos">
                </form>
</body>
</html>