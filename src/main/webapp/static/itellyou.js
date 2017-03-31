console.log('%c简易说明', 'background-image:-webkit-gradient( linear, left top, right top, color-stop(0, #f22), color-stop(0.15, #f2f), color-stop(0.3, #22f), color-stop(0.45, #2ff), color-stop(0.6, #2f2),color-stop(0.75, #2f2), color-stop(0.9, #ff2), color-stop(1, #f22) );color:transparent;-webkit-background-clip: text;font-size:5em;');
console.group("1--------------");
console.warn("author：lomo");
console.error("email：153917490@qq.com");
console.groupEnd();
console.group("2--------------");
//这里可以改为从数据库取数据展示json
//language=JSON
var json = "[{\"name\":\"tom\",\"role\":\"admin\",\"permission\":\"del\"},{\"name\":\"tom\",\"role\":\"normal\",\"permission\":\"query\"},{\"name\":\"jack\",\"role\":\"manager\",\"permission\":\"add\"},{\"name\":\"jack\",\"role\":\"manager\",\"permission\":\"update\"},{\"name\":\"jack\",\"role\":\"normal\",\"permission\":\"query\"},{\"name\":\"tom\",\"role\":\"normal\",\"permission\":\"query\"}]";
console.table(JSON.parse(json));
console.groupEnd()
