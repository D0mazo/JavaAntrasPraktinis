<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Importuojamas stilių failas -->
    <xsl:include href="styles.xsl"/>

    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <!-- Pagrindinis šablonas -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Siuntu Sarasas</title>

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
