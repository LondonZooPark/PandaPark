/**
 * 
 */
            window.onload = function() {
                //图片路径
                var arr = ['img/1.jpg', 'img/2.jpg', 'img/3.jpg', 'img/4.jpg', 'img/5.jpg'];
                //和图片路径匹配的文字描述
                var obt1 = document.getElementById("prev");//前一张图片的按钮
                var obt2 = document.getElementById("next");//后一张图片的按钮
                var oImg = document.getElementById("img1");//显示图片的标签
                var oP = document.getElementById("p1");//显示张数的文字标签
                var oSpan = document.getElementById("span1");//显示图片信息的标签
 
                var index = 0;//定位第几张图片的变量
 
                function funTab() {
                    oImg.src = arr[index];//给图片标签添加图片
                    oP.innerHTML = (index + 1) + "/" + arr.length;//修改上方的文字信息
                    oSpan.innerHTML = txt[index];//显示与之匹配的文字信息描述
                }
                funTab(); //第一次运行时 调用一次,进行初始化
                 
                obt1.onclick = prevImg;//当点击前一张按钮时,调用方法 显示前一张图片
                obt2.onclick = nextImg;//当点击后一张按钮是,调用方法显示后一张图片
 
                function nextImg() {
                    index++;//后一张,所以下标要增加1
                    if(index > arr.length - 1) {//如果移到到数组的最大下标
                        index = 0;//那么下标为0 . 这样就可以循环显示图片
                    }
                    funTab();//显示图片和搭配的文字信息
                };
 
                function prevImg() {
                    index--;//前一张图片.所以下标要减1
                    if(index < 0) {//如果下标小于 0 
                        index = arr.length - 1;//那么下标修改为最大下标  这样就可以循环显示图片
                    }
                    funTab();//显示图片和文字信息
                }
                //给文档绑定一个按键事件, 来响应键盘的按键
                document.onkeydown = function(event) {
                    //兼容主流浏览器的写法 获取按键事件
                    var e = event || window.event || arguments.callee.caller.arguments[0];
                    if(e && e.keyCode == 37) { // 按 左方向键 (37 是←方向键码值)
                        prevImg();//这里是方法调用 ,方法名后要加括号, 立刻调用方法
                    }
                    if(e && e.keyCode == 39) { // 按 右方向键(39 是→方向键码值)
                        nextImg();//这里是方法调用 ,方法名后要加括号, 立刻调用方法
                    }
                };
            }