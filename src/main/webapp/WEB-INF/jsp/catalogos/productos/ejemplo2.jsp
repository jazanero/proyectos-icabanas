<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<html>
	<head> 
		<title>Ejemplo1</title>
		<link rel="stylesheet" type="text/css" href="/displaytag/css/displaytag/displaytag.css" /> 
	</head> 
	
	<body id="page-home"> 
	
		<div id="page">
							
	        <div id="content"> 	    		    		   	
					    		
				<div id="contentForm" class="frame tbar" >								
					
					<display:table name="productos">
						<display:caption title="Listado de productos" />						
						<display:column property="nombre" title="Nombre" />
						<display:column property="descripcion" title="Descripci�n" />
						<display:footer>
							<tr>
						        <td colspan="2">Pie - Cualquier sumatorio o c�digo puede ir aqu�</td>
						      </tr>
						</display:footer>
					</display:table>
					
				</div>    		
								
			</div>				
			<!-- FIN CONTENT -->
			
		</div>
	</body>
 
</html>
