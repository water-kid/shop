// const { app, BrowserWindow } = require('electron')
// const createWindow = () => {
//     const win = new BrowserWindow({
//         width: 800,
//         height: 600
//     })
//
//     win.loadFile('index.html')
// }
//
// // 只有在 app 模块的 ready 事件被激发后才能创建浏览器窗口。
// // 监听ready事件
// app.whenReady().then(() => {
//     createWindow()
// })
//
//
// // 关闭所有窗口时退出应用 (Windows & Linux)
// app.on('window-all-closed', () => {
//     if (process.platform !== 'darwin') app.quit()
// })



const {app, BrowserWindow} =require('electron');//引入electron
let win;
let windowConfig = {
    width:800,
    height:600
};//窗口配置程序运行窗口的大小
function createWindow(){
    win = new BrowserWindow(windowConfig);//创建一个窗口
    win.loadURL(`file://${__dirname}/index.html`);//在窗口内要展示的内容index.html 就是打包生成的index.html
    win.webContents.openDevTools();  //开启调试工具
    win.on('close',() => {
        //回收BrowserWindow对象
        win = null;
    });
    win.on('resize',() => {
        win.reload();
    })
}
app.on('ready',createWindow);
app.on('window-all-closed',() => {
    app.quit();
});
app.on('activate',() => {
    if(win == null){
        createWindow();
    }
});

