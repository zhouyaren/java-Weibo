cur = 1; //����ȫ�ֱ���
function bigsmall(id){
   cur = cur * (-1);
   var imgid=document.getElementById("imgid"+id);
   //var a = document.getElementById("img");
   if(cur == 1)
   {
	//width="89" height="120" 
	   imgid.height="120"
	   imgid.width="89"
	   imgid.style.cursor = "mouse/0001.ani"; //��ǰд��"url(mouse/0001.ani)" ����������,ע���������˷����Һþ�ʱ�䡣
   }else{
	   imgid.width="267"
	   imgid.height="360"
	   imgid.style.cursor = "mouse/0132.ani";
   }
   //alert(cur);
}