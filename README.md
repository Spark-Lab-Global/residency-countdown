<div align="center">

# 倒计时

Spark Lab Residency 自用 · 全屏倒计时  
单文件，打开即用

</div>

<p align="center">
  <a href="https://github.com/Spark-Lab-Global"><img src="https://img.shields.io/badge/Spark%20Lab-Global-111111?style=flat-square&logo=github&labelColor=222" alt="Spark Lab Global" /></a>
  <img src="https://img.shields.io/badge/HTML5-single%20file-E34F26?style=flat-square&logo=html5&logoColor=white" alt="HTML5" />
  <img src="https://img.shields.io/badge/build-none-555555?style=flat-square" alt="No build" />
  <img src="https://img.shields.io/badge/Awesome-yes-ff69b4?style=flat-square&logo=awesomelists&logoColor=white" alt="Awesome" />
  <img src="https://img.shields.io/badge/repo-private-6e40c9?style=flat-square&logo=github" alt="Private" />
</p>

<p align="center">
  <a href="#内网使用">内网</a> · <a href="#本地下载">本地下载</a> · <a href="#技术说明">技术</a> · <a href="#修改规范">规范</a> · <a href="CHANGELOG.md">更新记录</a>
</p>

---

## 内网使用

（部署在 **NAS** 上。）团队已在 **内网** 提供 HTTP 访问，打开浏览器即可用全屏倒计时（与仓库内主文件 `S5-Residency-Countdown.html` 对应）。

- **地址**：<http://10.10.10.4:5000/>（仅内网可访问，未连内网时无法打开属正常现象）  
- **怎么用**（按顺序即可）：
  1. **先连上内网**（例如连上实验室/办公室的 **WiFi**，或已接入同网段的有线网络）。  
  2. 在上述内网环境下，用浏览器打开上面地址，即可使用；无需从 GitHub 再下载一次。

若你不在该网络里（如在家、手机流量），会访问不到此地址，请用下方「本地下载」从仓库取 `S5-Residency-Countdown.html` 自行打开。NAS 的 IP 或端口若将来有调整，以维护者通知为准。

---

## 本地下载

适用场景：不在内网、或想拿一份**本地副本**随开随用。  
**默认操作**：先从 GitHub 把 **`S5-Residency-Countdown.html`** 存到本机，再在资源管理器里**双击**该文件，或用浏览器的「打开文件 / Open File」从磁盘选择它（和打开别的 `.html` 一样）。

> 点进主文件在 GitHub 上的页面：  
> **[S5-Residency-Countdown.html（`main` 分支）](https://github.com/Spark-Lab-Global/residency-countdown/blob/main/S5-Residency-Countdown.html)**（也可从仓库 [根目录](https://github.com/Spark-Lab-Global/residency-countdown) 点进该文件。）

在文件内容**上方**的 GitHub 工具条里，你可以用下面**两种方式**之一，不必都做。

### 1. 推荐：直接下载（最省事）

- 在工具条**右侧**找 **「下载 / Download」** 或 **「⋯ / More file actions」** 菜单，选择 **`Download raw file`**。  
- 各版本界面会略有不同：有时是单独的下载图标，有时在 `⋯` 里；**目标都是把原始 `.html` 原样存到本机。**

为便于在页面上「对上号」，**下载**在 GitHub 上常用下面这类「向下箭头/保存」图标（仅代表样式，不保证与线上一比一像素相同）：

<p align="center">
  <img src="https://cdn.jsdelivr.net/npm/@primer/octicons@19.8.0/build/svg/download-24.svg" width="32" height="32" alt="下载图标（箭头像指向托盘，示意）" />
  <br />
  <sub>示意：与文件页上「保存 / Download raw file」一类的操作对应</sub>
</p>

保存完成后，在本地**双击**该 HTML 即可全屏使用。

### 2. 备用：先 Raw 再另存

若上面入口找不到、或你更习惯**纯文本**那一页：

1. 在同一工具条中点击 **「Raw」**，进入**仅原始内容**的页面；  
2. 用 **Ctrl+S / ⌘+S 另存为** 到本地，或在浏览器中直接打开，再视情况保存。

---

## 技术说明

- **单文件**：HTML 内已含样式与脚本，无需构建。  
- **字体**：使用 Google Fonts，首次打开需能访问外网。  
- **时间与逻辑**：均写在该文件中；改期、改起止，只动这一处里配置区与相关注释所指的代码。

### 部署与参考（Reference）

- 内网站点背后的同步与面板配置（如通过 **1Panel** 等从 GitHub 拉取/部署静态内容）的详细说明，见博客文章：  
  **[1Panel 自动同步 GitHub 仓库](https://blog.liushen.fun/posts/327826ac/)**（LiuShen's Blog：筑站与自动化思路，可按需对照你们 NAS 上的实际设置）。

---

## 修改规范

- 主发布：始终使用根目录 **`S5-Residency-Countdown.html`**。  
- 旧版：放在 **`archive/`**，不要与当前 S5 混用。  
- 远程：<https://github.com/Spark-Lab-Global/residency-countdown> · 首次推送等见 **`docs/github-setup.md`**（仅维护者）。

> 本仓库不单独附 License，内部使用。变更说明见 [**CHANGELOG.md**](CHANGELOG.md)。
