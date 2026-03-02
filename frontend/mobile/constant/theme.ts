// theme.ts

// 1. Palette: Xanh dương (Chủ đạo), Đỏ & Cam (Điểm nhấn)
const Palette = {
    // Brand Colors
    bluePrimary: '#0052FF',  // Xanh dương hiện đại (giống Coinbase/Facebook)
    blueDark: '#0035A5',     // Xanh dương sâu (cho trạng thái nhấn)
    redAction: '#FF3B30',    // Đỏ năng động (Apple style)
    orangeAccent: '#FF9500', // Cam rực rỡ (tăng tính tương tác)
    greyNeutral: '#d4d4d4',    // Xám trung tính (cho text phụ)

    // Neutral Colors (Light)
    lightBg: '#F8F9FB',
    lightSurface: '#FFFFFF',
    lightText: '#1A1C1E',
    lightSubtext: '#6C757D',
    lightBorder: '#E9ECEF',

    // Neutral Colors (Dark)
    darkBg: '#0F1014',       // Đen nhám sâu
    darkSurface: '#242830',  // Xám đen (Card nền tối)
    darkSpacer: '#0F1014',    // Màu nền chính (giống Twitter Dark)
    darkText: '#F8F9FA',
    darkSubtext: '#ADB5BD',
    darkBorder: '#2C2E33',
};

const SharedTheme = {
    spacing: {
        xs: 4, s: 8, m: 16, l: 24, xl: 32,
    },
    borderRadius: {
        s: 6,
        m: 14, // Bo góc lớn nhìn trẻ trung hơn
        l: 24,
        full: 9999,
    },
    typography: {
        h1: { fontSize: 30, fontWeight: '800' as const },
        body: { fontSize: 20, fontWeight: '400' as const },
        subtitle: { fontSize: 16, fontWeight: '600' as const },
        button: { fontSize: 16, fontWeight: '600' as const },
    },
};

// 2. Light Theme: Trong sáng, tin cậy
export const LightTheme = {
    ...SharedTheme,
    ...Palette,
    colors: {
        primary: Palette.bluePrimary,   // Xanh dương làm màu chính
        secondary: Palette.orangeAccent, // Cam làm màu nhấn (như nút Mua ngay)
        error: Palette.redAction,      // Đỏ dùng cho cảnh báo/xóa
        warning: Palette.orangeAccent,

        backgroundPrimary: Palette.bluePrimary,
        backgroundSecondary: Palette.lightBg,
        backgroundSpacer: Palette.greyNeutral,
        surface: Palette.lightSurface,
        textColor: Palette.lightText,
        subtext: Palette.lightSubtext,
        borderColor: Palette.lightBorder,
    },
};

// 3. Dark Theme: Mạnh mẽ, cá tính
export const DarkTheme = {
    ...SharedTheme,
    ...Palette,
    colors: {
        primary: '#4D8BFF',            // Xanh dương sáng hơn một chút để nổi trên nền đen
        secondary: Palette.orangeAccent,
        error: Palette.redAction,
        warning: Palette.orangeAccent,

        backgroundPrimary: Palette.darkBg,
        backgroundSecondary: Palette.darkSurface,
        backgroundSpacer: Palette.darkSpacer,
        surface: Palette.darkSurface,
        textColor: Palette.darkText,
        subtext: Palette.darkSubtext,
        borderColor: Palette.darkBorder,
    },
};