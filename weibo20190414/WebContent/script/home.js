// JavaScript Document
//΢���ı���ȡ����
function blogtextfocus(){
	if(document.getElementById("blogtext").value == "��������ʲô��"){
	document.getElementById("blogtext").value="";
	document.getElementById("blogtext").style.color="#000000";
	}
}
//΢���ı�ʧȥ����
function blogtextblur(){
	if(document.getElementById("blogtext").value == ""){
	document.getElementById("blogtext").value="��������ʲô��";
	document.getElementById("blogtext").style.color="#999999";
	}	

	//΢����������

function checktext(text){
	allValid = true;
	for (i = 0;  i < text.length;  i++)
	{
		if (text.charAt(i) != " ")
				{
					allValid = false;
					break;
				}
			}
	return allValid;
	}

	function gbcount(message,total,used,remain)
	{
		var max;
		max = total.value;
		if (message.value.length > max) {
		message.value = message.value.substring(0,max);
		used.value = max;
		remain.value = 0;
		alert("���Բ��ܳ��� 140 ����!");
		}
		else {
		used.value = message.value.length;
		remain.value = max - used.value;
		}
	}
}

//textaera ��ʵ������
function display(mid){
	var text=document.getElementById("divtext"+mid);
	if(text.style.display=="none"){
		text.style.display="block";
	}else{
		text.style.display="none";
	}
	}