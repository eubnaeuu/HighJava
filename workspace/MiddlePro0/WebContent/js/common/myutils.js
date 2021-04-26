/**
 * 
 */

function getValue(url, key){
	// url = "http://localhost:9090/JqueryPro/html/jquery9/jquery9_submit_result.html?userName=아이유&userAge=25"
	var idx = url.indexOf("?");
	if(idx > -1) {
		url = url.substr(idx + 1);
		// url = "userName=아이유&userAge=25"
		
		var arr = url.split("&");
		// ["userName=아이유", "userAge=25"]
		
		for(var i = 0 ; i<arr.length ; i++) {
			//arr[i];// "userName=아이유" 또는 "userName="
			var tmp = arr[i].split("=");
			// ["userName", "아이유"]
			if(tmp[0] == key) {
				if(tmp.length > 1) {
					return tmp[1];
				} else {
					return "";
				}
			}
		}
	}
	
}

function isEmpty(val) {
	if(val == undefined) return true;
	if(val == null) return true;
	if(val == "null") return true;
	
	val = jQuery.trim(val);
	if(val.length == 0) return true;
	
	return false;
}

function changeEmptyVal(val) {
	if(isEmpty(val)) return "";
	else return val;
}

/** 핸드폰 번호 포맷 */
function formatHp(val){
	//val : 01012341234, 010-1234-1234, 010-12341234, 0101234-1234
	//      010 1234 1234, 010 12341234, 0101234 1234
	val = val.replaceAll("-", "").replaceAll(" ", "");
	
	// 010-123-1234, 010-1234-1234
	val = val.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1-$2-$3");
	return val;
}
