const defaultTheme = require('tailwindcss/defaultTheme')

module.exports = {
  content: [
    'src/main/resources/**/*.html',
    'src/main/resources/**/*.{js,jsx,ts,tsx}',
  ],
  theme: {
    extend: {
      colors: {
        'taming-thymeleaf-green':'darkseagreen'
      },
      fontFamily: {
        sans: ['Inter var', ...defaultTheme.fontFamily.sans],
      },
    },
  },
  plugins: [
    require('@tailwindcss/typography'),
    require('@tailwindcss/forms'),
    require('@tailwindcss/line-clamp'),
    require('@tailwindcss/aspect-ratio')
  ],
}
