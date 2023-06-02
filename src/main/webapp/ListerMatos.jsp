<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="n7.fr.metier.*" %>
<%
    Map<String, List<Materiel>> matos = (Map<String, List<Materiel>>) request.getSession().getAttribute("allMatos");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Material Listing</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .delete-button {
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .delete-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Material Type</th>
            <th>Name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <% 
            for (Map.Entry<String, List<Materiel>> entry : matos.entrySet()) {
                String type = entry.getKey();
                List<Materiel> materials = entry.getValue();
                if (materials == null) {
                    continue;
                } else {
                    for (Materiel material : materials) {
        %>
                        <tr>
                            <td><%= material.getId() %></td>
                            <td><%= type %></td>
                            <td><%= material.getNom() %></td>
                            <td><%= material.getDescription() %></td>
                            <td>
                                <form action="ControllerDeleteMatos" method="get">
                                    <input type="hidden" name="materialId" value="<%= material.getId() %>">
                                    <button type="submit" class="delete-button">Supprimer</button>
                                </form>
                            </td>
                        </tr>
        <% 
                    }
                }
            }
        %>
    </table>
</body>
</html>
