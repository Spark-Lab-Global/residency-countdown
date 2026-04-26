<div align="center">

# 倒计时

Spark Lab Residency 自用 · 全屏倒计时  
单文件，打开即用

</div>

<p align="center">
  <a href="https://github.com/Spark-Lab-Global"><img src="https://img.shields.io/badge/Spark%20Lab-Global-111111?style=flat-square&logo=github&labelColor=222" alt="Spark Lab Global" /></a>
  <img src="https://img.shields.io/badge/HTML5-single%20file-E34F26?style=flat-square&logo=html5&logoColor=white" alt="HTML5" />
  <img src="https://img.shields.io/badge/web-no%20build-555555?style=flat-square" alt="Web no build" />
  <img src="https://img.shields.io/badge/apk-wrapper%20integrated-1f6feb?style=flat-square" alt="APK wrapper integrated" />
  <img src="https://img.shields.io/badge/Awesome-yes-ff69b4?style=flat-square&logo=awesomelists&logoColor=white" alt="Awesome" />
  <img src="https://img.shields.io/badge/repo-private-6e40c9?style=flat-square&logo=github" alt="Private" />
</p>

<p align="center">
  <a href="#网络使用">网络</a> · <a href="#本地下载">本地下载</a> · <a href="#android-apk">Android APK</a> · <a href="#技术说明">技术</a> · <a href="#联系与审核">联系</a> · <a href="#修改规范">规范</a> · <a href="CHANGELOG.md">更新记录</a>
</p>

---

## 网络使用

在浏览器中打开全屏页即可（与主文件 `S5-Residency-Countdown.html` 一致）。**优先**用下表 **1**；**不在内网**时，公网入口见下表 **2**（或备选 **3**），或最下方「本地下载」到本地。

| # | 方式 | 地址与说明 |
|---|------|------------|
| 1 | **内网（推荐）** | <http://10.10.10.4:5000/>（**NAS** 上部署；仅**内网**可达，未连内网时打不开是正常现象。）<br>先接 **Spark Lab** 或 **Spark Lab-5G** 的 **WiFi**，或同网段有线，再在浏览器中打开。无需从 GitHub 下载。 |
| 2 | **公网（推荐）** | <https://residency-countdown.rth1.xyz/>：经 [**热铁盒网页托管**](https://host.retiehe.com/) 在国内环境构建的镜像，**不依赖**境外 CDN，适合国内网络直连访问，速度较快且稳定。 |
| 3 | **公网（备选·Vercel）** | <https://residency-countdown.vercel.app/>：仓库在 **Vercel** 上部署；CDN 在**国内未加速**，可能偏慢或偶发卡顿。若**能稳定访问** Vercel（常需**境外网络或挂 VPN**）或主公网（上表 2）异常时可作为备选。页面里 **Google Fonts** 等走公网拉取。 |

**公网在国内怎么选**（与上表 2、3 同一套单页，只是访问路径不同）：

- **国内、公网推荐**：<https://residency-countdown.rth1.xyz/> — 经 [热铁盒网页托管](https://host.retiehe.com/) 在国内环境提供，**不依赖**境外 CDN，适合日常直连。  
- **需要备选**（上表 2 打不开、人在境外或能稳定用 Vercel 时）：<https://residency-countdown.vercel.app/>（见上表 3）。  

内网 **IP/端口** 若调整，以维护者通知为准；Vercel 的用量以 [Vercel](https://vercel.com) 为准；热铁盒与 DNS 以实际解析为准。

---

## 本地下载

适用场景：不在内网、或想拿一份**本地副本**随开随用。  
**默认操作**：先从 GitHub 把 **`S5-Residency-Countdown.html`** 存到本机，再在资源管理器里**双击**该文件，或用浏览器的「打开文件 / Open File」从磁盘选择它（和打开别的 `.html` 一样）。

> 点进主文件在仓库上的页面：  
> **[S5-Residency-Countdown.html（`main` 分支）](https://github.com/Spark-Lab-Global/residency-countdown/blob/main/S5-Residency-Countdown.html)**（也可从仓库 [根目录](https://github.com/Spark-Lab-Global/residency-countdown) 点进该文件。）

在文件**上方**的 GitHub 工具条，**任选一种**方式即可。

### 1. 推荐：直接下载

在**右上角**点击下方图标下载 html 文件。

> <p align="center">
>   <img src="https://cdn.jsdelivr.net/npm/@primer/octicons@19.8.0/build/svg/download-24.svg" width="32" height="32" alt="下载（示意，与 Download raw file 对应）" />
> </p>

文件存到本机后，然后在资源管理器里**双击**打开；或用浏览器下载列表打开该文件

### 2. 备用：Raw

找不到上面入口时，点右上角 **「Raw」**，**另存为**（Ctrl+S / ⌘+S）为 `.html` 即可。

---

## Android APK

适用场景：把当前倒计时页作为 **Android TV / 电视盒子 APK** 运行，例如小米电视等带安卓系统的设备。

> 当前说明：仓库里的 **`android-apk/` 工程已经整理好**，但**新的 APK 还没有在有 Docker / Android SDK 的环境里重新分包**。  
> 因此，电视上实际安装运行的 APK 仍应视为**上一个构建版本**：它**尚未正式验证并支持当前主线 HTML 的最新时间 fallback 处理**；在电视上，**`Ship it Monday`** 与**主倒计时**仍可能出现时间显示异常。  
> 后续需要在**有 Docker 的环境**里重新构建 APK，再回到电视设备验证并修正。

- Android 工程已收进仓库子目录 **[`android-apk/`](./android-apk/README.md)**，它是**封装层**，不是第二套产品实现。  
- **唯一事实源**仍然是根目录 **`S5-Residency-Countdown.html`** 与 **`fonts/`**；APK 构建前会先把它们同步进 Android assets。  
- 这样后续改网页主文件时，APK 不需要再手工维护另一份漂移的 HTML 副本。

### 构建方式

在仓库根目录执行：

```bash
./android-apk/build.sh
```

说明：

- 该脚本会先同步最新的 **`S5-Residency-Countdown.html`** 与 **`fonts/`**。  
- 再通过 **Docker** 中的 Android SDK / Gradle 环境构建 release APK。  
- 成品默认复制到桌面，便于再拷到 U 盘或直接分发到电视设备。
- **当前仓库尚未在本机完成这一步**；这里只保留工程与脚本，等待后续在可构建环境中重新出包。

### 运行时说明

- APK 入口是一个 **全屏 WebView**，加载同步进 assets 的 **`S5-Residency-Countdown.html`**。  
- 字体策略与网页主线保持一致：**优先 Google Fonts，失败/离线时 fallback 到本地字体**。  
- 针对 Android TV / WebView 的时间兼容性，页面保留 **`Intl` / `toLocaleString` 主路径**，并在异常时退回固定 **UTC+8** 推导；APK 还额外提供原生毫秒时间桥接，优先给主倒计时与 **Ship it Monday** 使用。
- 以上兼容性逻辑已经整理进工程与资产目录，但**是否真的修复电视上的时间问题，要以重新构建后的 APK 实机验证为准**。

更具体的 Android 维护说明见 **[`android-apk/README.md`](./android-apk/README.md)**。

---

## 技术说明

- **网页主线**：根目录 **`S5-Residency-Countdown.html`** 为主发布文件；HTML 内含样式与脚本，无需网页构建。  
- **字体**：默认优先 Google Fonts；加载失败、离线或断网时 fallback 到本地 **`fonts/google-fonts-local.css`** 与同目录 woff2。  
- **时间与逻辑**：核心仍写在该文件中；针对 Android TV / WebView，关键时间推导保留 fallback，尽量不因运行时差异而失效。  
- **APK 封装**：`android-apk/` 只负责把当前主线网页封装为 Android APK，不应演化成第二套独立实现。

### 部署与参考（Reference）

- **内网 NAS**：与 **1Panel** 等从 GitHub 拉取/部署有关的做法，见博客  
  **[1Panel 自动同步 GitHub 仓库](https://blog.liushen.fun/posts/327826ac/)**。  
- **Vercel**：根目录的 **`vercel.json`** 仅把路径 **`/`** 重写到 **`S5-Residency-Countdown.html`**。这样**不增加** `index.html` 副本、主文件**仍只维护 S5 这一份**；`https://你的域名/S5-Residency-Countdown.html` 也仍可直链。若同站点将来要加其它资源路径，**不要**把全站 `/(.*)` 都重写到 S5，以免误伤。

---

## 联系与审核

仓库**内部**对接、主维护与**审核/协作**请优先联系（GitHub，好留痕、好抄送）：

- [**Jah-yee**](https://github.com/Jah-yee) — 主要开发、日常维护与发布。  
- [**WorldSansha（三傻）**](https://github.com/WorldSansha) — 内网 **NAS** 部署、同步与相关协作。  

> 公网 **Vercel**、**国内热铁盒镜像**与组织权限、私有库策略等，以实际维护者说明为准。  

---

## 修改规范

- 主发布：始终使用根目录 **`S5-Residency-Countdown.html`**。  
- Android 封装：放在 **`android-apk/`**；若改 APK 行为，优先判断是否应先改根目录 **S5** 与 **fonts** 这两个事实源。  
- 旧版：放在 **`archive/`**，不要与当前 S5 混用。  
- 远程：<https://github.com/Spark-Lab-Global/residency-countdown> · 首次推送等见 **`docs/github-setup.md`**（仅维护者）。

> 本仓库不单独附 License，内部使用。变更说明见 [**CHANGELOG.md**](CHANGELOG.md)。
