<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <!-- Pagrindinis šablonas -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Siuntu Sarasas</title>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    margin: 40px;
                    background-color: #f4f4f4;
                    }
                    h1 {
                    color: #333;
                    }
                    h2 {
                    color: #e65c00;
                    }
                    h3 {
                    color: #f9a825;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    background-color: #fff;
                    margin-bottom: 30px;
                    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
                    }
                    th {
                    background-color: #e65c00;
                    color: white;
                    padding: 10px;
                    text-align: left;
                    }
                    td {
                    padding: 8px 10px;
                    border-bottom: 1px solid #ddd;
                    }
                    tr:hover {
                    background-color: #f9f9f9;
                    }
                    .produktai-table th {
                    background-color: #f9a825;
                    color: white;
                    }
                    .pristatyta-taip {
                    color: green;
                    font-weight: bold;
                    }
                    .pristatyta-ne {
                    color: red;
                    font-weight: bold;
                    }
                </style>
            </head>
            <body>
                <h1>Siuntos</h1>
                <xsl:apply-templates select="siuntos/siunta"/>
            </body>
        </html>
    </xsl:template>

    <!-- Kiekvienos siuntos šablonas -->
    <xsl:template match="siunta">
        <h2>Siunta Nr. <xsl:value-of select="id"/></h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Gavejas</th>
                <th>Adresas</th>
                <th>Svoris (kg)</th>
                <th>Kaina (EUR)</th>
                <th>Prioritetas</th>
                <th>Pristatyta</th>
            </tr>
            <tr>
                <td><xsl:value-of select="id"/></td>
                <td><xsl:value-of select="gavėjas"/></td>
                <td><xsl:value-of select="adresas"/></td>
                <td><xsl:value-of select="svoris"/></td>
                <td><xsl:value-of select="kaina"/></td>
                <td><xsl:value-of select="prioritetas"/></td>
                <td>
                    <xsl:choose>
                        <xsl:when test="pristatyta = 'true'">
                            <span class="pristatyta-taip">Taip</span>
                        </xsl:when>
                        <xsl:otherwise>
                            <span class="pristatyta-ne">Ne</span>
                        </xsl:otherwise>
                    </xsl:choose>
                </td>
            </tr>
        </table>

        <h3>Produktai</h3>
        <table class="produktai-table">
            <tr>
                <th>ID</th>
                <th>Pavadinimas</th>
                <th>Kiekis</th>
                <th>Kaina (EUR)</th>
            </tr>
            <xsl:apply-templates select="produktai/produktas"/>
        </table>
    </xsl:template>

    <!-- Kiekvieno produkto šablonas -->
    <xsl:template match="produktas">
        <tr>
            <td><xsl:value-of select="id"/></td>
            <td><xsl:value-of select="pavadinimas"/></td>
            <td><xsl:value-of select="kiekis"/></td>
            <td><xsl:value-of select="kaina"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>