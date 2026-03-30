<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Stilių šablonas -->
    <xsl:template name="styles">
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
    </xsl:template>

</xsl:stylesheet>