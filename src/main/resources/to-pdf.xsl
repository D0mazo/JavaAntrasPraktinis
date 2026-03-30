<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:output method="xml" indent="yes"/>

    <!-- Pagrindinis šablonas -->
    <xsl:template match="/">
        <fo:root>

            <!-- Puslapio išdėstymo nustatymai -->
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4-puslapis"
                                       page-height="29.7cm"
                                       page-width="21cm"
                                       margin-top="1.5cm"
                                       margin-bottom="1.5cm"
                                       margin-left="2cm"
                                       margin-right="2cm">
                    <fo:region-body margin-top="1cm" margin-bottom="1cm"/>
                    <fo:region-before extent="1cm"/>
                    <fo:region-after extent="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <!-- Puslapio seka -->
            <fo:page-sequence master-reference="A4-puslapis">

                <!-- Antraštė (viršuje) -->
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block font-size="8pt"
                              color="#888888"
                              text-align="right"
                              border-bottom="0.5pt solid #cccccc"
                              padding-bottom="4pt">
                        Siuntos - Logistikos sistema
                    </fo:block>
                </fo:static-content>

                <!-- Poraštė (apačioje) -->
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block font-size="8pt"
                              color="#888888"
                              text-align="center"
                              border-top="0.5pt solid #cccccc"
                              padding-top="4pt">
                        Puslapis <fo:page-number/> iš <fo:page-number-citation ref-id="paskutinis-puslapis"/>
                    </fo:block>
                </fo:static-content>

                <!-- Pagrindinis turinys -->
                <fo:flow flow-name="xsl-region-body">

                    <!-- Dokumento pavadinimas -->
                    <fo:block font-size="22pt"
                              font-weight="bold"
                              color="#e65c00"
                              text-align="center"
                              space-after="10pt"
                              border-bottom="2pt solid #e65c00"
                              padding-bottom="6pt">
                        Siuntos
                    </fo:block>

                    <fo:block font-size="10pt"
                              color="#666666"
                              text-align="center"
                              space-after="20pt">
                        Logistikos sistemos ataskaita
                    </fo:block>

                    <!-- Kiekviena siunta -->
                    <xsl:apply-templates select="siuntos/siunta"/>

                    <!-- Paskutinio puslapio žymė -->
                    <fo:block id="paskutinis-puslapis"/>

                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <!-- Siuntos šablonas -->
    <xsl:template match="siunta">

        <!-- Siuntos antraštė -->
        <fo:block font-size="14pt"
                  font-weight="bold"
                  color="#ffffff"
                  background-color="#e65c00"
                  padding="6pt"
                  space-before="15pt"
                  space-after="6pt">
            Siunta Nr. <xsl:value-of select="id"/>
        </fo:block>

        <!-- Siuntos informacijos lentelė -->
        <fo:table table-layout="fixed" width="100%"
                  border="0.5pt solid #dddddd"
                  space-after="10pt">
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>

            <!-- Lentelės antraštė -->
            <fo:table-header>
                <fo:table-row background-color="#e65c00">
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">ID</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Gavejas</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Adresas</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Svoris (kg)</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Kaina (EUR)</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Pristatyta</fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>

            <!-- Lentelės turinys -->
            <fo:table-body>
                <fo:table-row background-color="#fff8f5">
                    <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                        <fo:block font-size="9pt"><xsl:value-of select="id"/></fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                        <fo:block font-size="9pt"><xsl:value-of select="gavėjas"/></fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                        <fo:block font-size="9pt"><xsl:value-of select="adresas"/></fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                        <fo:block font-size="9pt"><xsl:value-of select="svoris"/></fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                        <fo:block font-size="9pt"><xsl:value-of select="kaina"/></fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                        <xsl:choose>
                            <xsl:when test="pristatyta = 'true'">
                                <fo:block font-size="9pt" color="green" font-weight="bold">Taip</fo:block>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:block font-size="9pt" color="red" font-weight="bold">Ne</fo:block>
                            </xsl:otherwise>
                        </xsl:choose>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>

        <!-- Produktų antraštė -->
        <fo:block font-size="11pt"
                  font-weight="bold"
                  color="#ffffff"
                  background-color="#f9a825"
                  padding="5pt"
                  space-after="4pt">
            Produktai
        </fo:block>

        <!-- Produktų lentelė -->
        <fo:table table-layout="fixed" width="100%"
                  border="0.5pt solid #dddddd"
                  space-after="20pt">
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(3)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>
            <fo:table-column column-width="proportional-column-width(1)"/>

            <fo:table-header>
                <fo:table-row background-color="#f9a825">
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">ID</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Pavadinimas</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Kiekis</fo:block>
                    </fo:table-cell>
                    <fo:table-cell padding="5pt" border="0.5pt solid #ffffff">
                        <fo:block font-weight="bold" color="#ffffff" font-size="9pt">Kaina (EUR)</fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-header>

            <fo:table-body>
                <xsl:apply-templates select="produktai/produktas"/>
            </fo:table-body>
        </fo:table>

    </xsl:template>

    <!-- Produkto šablonas -->
    <xsl:template match="produktas">
        <fo:table-row>
            <xsl:if test="position() mod 2 = 0">
                <xsl:attribute name="background-color">#fff8f5</xsl:attribute>
            </xsl:if>
            <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                <fo:block font-size="9pt"><xsl:value-of select="id"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                <fo:block font-size="9pt"><xsl:value-of select="pavadinimas"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                <fo:block font-size="9pt"><xsl:value-of select="kiekis"/></fo:block>
            </fo:table-cell>
            <fo:table-cell padding="5pt" border="0.5pt solid #dddddd">
                <fo:block font-size="9pt"><xsl:value-of select="kaina"/></fo:block>
            </fo:table-cell>
        </fo:table-row>
    </xsl:template>

</xsl:stylesheet>
